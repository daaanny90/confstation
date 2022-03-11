<template>
  <footer>
    <router-link to="/intro" v-if="$route.name === 'mainstage'"
      >zurück zum Start</router-link
    >
    <router-link to="/status" v-if="$route.name === 'mainstage'"
      >Go to outro</router-link
    >
  </footer>
</template>

<script>
import { Vue } from "vue-class-component";

export default class Footer extends Vue {}
</script>

<style lang="scss" scoped>
footer {
  height: 96px;
  border-top: 1px solid $grey;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;

  a {
    margin: 0 2rem;
  }
}
</style>
