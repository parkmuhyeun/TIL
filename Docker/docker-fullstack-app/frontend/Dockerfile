FROM node:apline as builder
WORKDIR /app
COPY ./package.json ./
RUN npm install
COPY . .
RUN npm run builder

FROM nginx
EXPOSE 3000
COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /app/build /usr/shre/nginx/html