# Validation
#TIL/스프링 MVC2

---
## Validation
BindingResult 활용해 검증 오류를 표현(BindingResult 파라미터 위치는 바인딩 할 객체 다음에 와야 됨)
- 타임리프에서 제공하는 Validation
    - #fields: #fields 로 BinddingResult가 제공하는 검증오류에 접근가능
    - th:errors: 해당 필드에 오류가 있는경우
    - th:errorclass: th:field에서 지정한 필드에 오류가 있으면 class 정보 추가

### BindingResult에 검증오류를 적용하는 3가지 방법
- 객체에 타입 오류 등으로 바인딩이 실패하는 경우 스프링이 FieldError 생성해서 BindingResult에 넣어준다(typeMismatch)
- 개발자가 직접 넣어준다.
- Validator 사용


[Validation 중간 진화과정(ValidationItenControllerV1 ~ V4) -> Validation 폴더]

## Validation 최종형태(Bean Validation )
아이템 Entity
```java
@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;
}
```

ITEM 저장용 폼
```java
@Data
public class ItemSaveForm {
    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;

    @NotNull
    @Max(value = 9999)
    private Integer quantity;
 }
```



ITEM 수정용 폼
```java
@Data
public class ItemUpdateForm {
    @NotNull
    private Long id;

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;

    //수정에서는 수량은 자유롭게 변경할 수 있다.
    private Integer quantity;
}
```

 컨트롤러(일부)
```java

//추가
@PostMapping("/add")
 public String addItem(@Validated @ModelAttribute("item") ItemSaveForm form,
BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    //특정 필드 예외가 아닌 전체 예외
    if (form.getPrice() != null && form.getQuantity() != null) {
        int resultPrice = form.getPrice() * form.getQuantity();
        if (resultPrice < 10000) {
            bindingResult.reject("totalPriceMin", new Object[]{10000,
            resultPrice}, null);
        }
    }

    if (bindingResult.hasErrors()) {
        log.info("errors={}", bindingResult);
        return "validation/v4/addForm";
    }

    //성공 로직
    Item item = new Item();
    item.setItemName(form.getItemName());
    item.setPrice(form.getPrice());
    item.setQuantity(form.getQuantity());

    Item savedItem = itemRepository.save(item);
    redirectAttributes.addAttribute("itemId", savedItem.getId());
    redirectAttributes.addAttribute("status", true);

    return "redirect:/validation/v4/items/{itemId}";
 }


//수정
@PostMapping("/{itemId}/edit")
 public String edit(@PathVariable Long itemId, @Validated
@ModelAttribute("item") ItemUpdateForm form, BindingResult bindingResult) {
    //특정 필드 예외가 아닌 전체 예외
    if (form.getPrice() != null && form.getQuantity() != null) {
        int resultPrice = form.getPrice() * form.getQuantity();
        if (resultPrice < 10000) {
            bindingResult.reject("totalPriceMin", new Object[]{10000,
            resultPrice}, null);
     }
    }

    if (bindingResult.hasErrors()) {
        log.info("errors={}", bindingResult);
        return "validation/v4/editForm";
    }
    
    Item itemParam = new Item();
    itemParam.setItemName(form.getItemName());
    itemParam.setPrice(form.getPrice());
    itemParam.setQuantity(form.getQuantity());
    
    itemRepository.update(itemId, itemParam);
    return "redirect:/validation/v4/items/{itemId}";
 }
```