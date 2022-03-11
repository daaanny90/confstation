<template>
  <div class="points-container d-flex flex-column justify-content-between">
    <p class="points-title">Hauptpreise <br />Punkte</p>
    <div
      class="points-base d-flex flex-column justify-content-center align-items-center"
    >
      <div
        class="cup"
        :style="'background-image: url(' + require('@/assets/cup.png') + ')'"
      ></div>
      <p class="points">350</p>
    </div>
    <div class="points-badge d-flex justify-content-center align-items-center">
      PRO
    </div>
  </div>
</template>

<script>
import { Vue } from "vue-class-component";

export default class Points extends Vue {}
</script>

<style lang="scss" scoped>
.points-container {
  position: relative;
}
.points-title {
  font-weight: bold;
  margin: 0;
}

.points-base {
  height: 80%;
  width: 100%;
  border-radius: 50%;
  border: 7px solid $grey;
  max-width: 7rem;
  margin: 0 auto;
  max-height: 7rem;

  .cup {
    background-position: center;
    background-size: contain;
    background-repeat: no-repeat;
    height: 30%;
    width: 100%;
  }

  .points {
    font-size: 2.5rem;
    color: $grey;
    font-weight: bold;
    height: 60%;
    width: 100%;
    margin: 0;
  }
}

.points-badge {
  position: absolute;
  width: 4rem;
  height: 1.7rem;
  background: red;
  bottom: -12px;
  left: 50%;
  transform: translate(-50%);
  border-radius: 5px;
  color: white;
  font-size: 0.9rem;
  font-weight: bold;
}
</style>
