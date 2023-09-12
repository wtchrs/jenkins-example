FROM node
LABEL authors="wtchrs"

WORKDIR /app
ADD . /app
RUN npm install

EXPOSE 3000
ENTRYPOINT ["npm", "run", "start"]
