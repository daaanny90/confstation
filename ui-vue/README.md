# Station Frontend

## Info
The project is a [Vue3](https://vuejs.org/guide/introduction.html) + [TypeScript](https://www.typescriptlang.org/docs/) + [Vuex](https://vuex.vuejs.org/) project.

The components are class based, [more information here.](https://class-component.vuejs.org/)

## Project setup
You need the dummy backend to send requests and receive JSON files. This is in the `business` folder.

First of all start the `business` container. After that the frontend container can be started with:
```
docker-compose up
```
The frontend is now reachable at http://localhost:8081

## Folder structure explanation

- `assets/`: all static assets used in the web app
- `components/`: all single reusable components
- `router/`: where all routes are defined
- `api/`: all API requests, organized by entity
- `store/`: where the state is defined along with getter, setter, etc.
- `interfaces/`: where the types of entites are defined
- `views/`: the "pages" of the web app

- `App.vue` is the actual web app
- `http-common.ts` is where the common API settings are defined

## Style

The project uses [Bootstrap 5](https://getbootstrap.com/docs/5.1/getting-started/introduction/) as CSS framework.
[Here](https://dev.to/codeply/using-bootstrap-5-with-vue-js-5fnp) can be found a little explanation how to use the Bootstrap components in Vue.

For any question please refer to [Danny](mailto:danny@ostec.de)