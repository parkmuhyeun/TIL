package com.muto.comment.controller;

import com.muto.comment.domain.Comment;
import com.muto.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;

    @GetMapping("/")
    String Home(Model model) {
        List<Comment> comments = commentRepository.findAll(Sort.by(Sort.Direction.ASC, "groupNumber", "groupOrder"));
        model.addAttribute("comments", comments);
        return "index";
    }

    @PostMapping("/comment")
    String createComment(String content) {
        log.info(content);

        Integer commentGroup = commentRepository.findCommentGroup().orElse(0);
        commentGroup += 1;
        Comment comment = Comment.builder()
                .content(content)
                .createDateTime(LocalDateTime.now())
                .groupNumber(commentGroup)
                .groupOrder(0)
                .build();
        commentRepository.save(comment);
        return "redirect:/";
    }

    @PostMapping("/recomment")
    String createRecomment(Long id, String content) {
        Comment root = commentRepository.findById(id).orElseThrow();

        Integer commentOrder = commentRepository.findCommentOrder(root.getGroupNumber());
        commentOrder += 1;
        Comment comment = Comment.builder()
                .content(content)
                .createDateTime(LocalDateTime.now())
                .groupNumber(root.getGroupNumber())
                .groupOrder(commentOrder)
                .build();
        commentRepository.save(comment);
        return "redirect:/";
    }
}
