<template>
  <div class="intro-container d-flex flex-column">
    <h1>
      Beautiful App Teaser. <br />
      Play Your Game.
    </h1>

    <p>
      Provide an overview of this Game Level benefits. <br />
      Lorem, ipsum dolor sit amet consectetur adipisicing elit. Eaque enim quas
      fuga dolore <br />
      repellendus et exercitationem.
    </p>

    <router-link to="QR">
      <Button goto="/QR" text="STARTEN" />
    </router-link>

    <a href="#" class="mt-2">(?) Hilfe</a>
  </div>
</template>

<script>
import { Vue, Options } from "vue-class-component";
import Button from "@/components/Button";

@Options({
  components: {
    Button,
  },
})
export default class Intro extends Vue {}
</script>

<style lang="scss" scoped>
.intro-container {
  background: $background-grey;
  height: 100%;
  text-align: left;
  padding: $container-padding;
  border-radius: $border-radius;
}

h1 {
  font-weight: bolder;
}

p {
  flex: 1;
}

button,
a {
  margin: 0 auto;
}

button {
  margin-bottom: 3rem;
}
</style>
