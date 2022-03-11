import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";
import Intro from "../views/Station/Intro.vue";
import Mainstage from "../views/Station/Mainstage.vue";
import QR from "../views/Station/QR.vue";
import Status from "../views/Station/Status.vue";
import Dashboard from "../views/Board/Dashboard.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/intro",
    name: "intro",
    component: Intro,
  },
  {
    path: "/QR",
    name: "QR",
    component: QR,
  },
  {
    path: "/mainstage",
    name: "mainstage",
    component: Mainstage,
  },
  {
    path: "/status",
    name: "status",
    component: Status,
  },
  {
    path: "/dashboard",
    name: "dashboard",
    component: Dashboard,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
