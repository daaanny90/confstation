FROM node:lts-alpine

WORKDIR /usr/src/app/my-app

COPY package*.json ./

RUN npm install -g @vue/cli && \
    npm install -g @vue/cli-service && \
    npm install

EXPOSE 3000

CMD ["npm", "run", "serve"]