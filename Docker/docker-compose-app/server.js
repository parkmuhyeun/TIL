const express = require("express");
const redis = require("redis");
//레디스 클라이언트 생성
const client = redis.createClient({
    host:"redis-server",
    port:6379
})

const app = express();

//숫자는 0 부터 시작
client.set("number", 0)

app.get('/', (req, res) => {
    client.get("number", (err, number) => {
        res.send("숫자가 1씩 올라갑니다. 숫자: " + number)
        client.set("number", parseInt(number) + 1)
    })
})


app.listen(8080);
console.log("Server is running");