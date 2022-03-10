<template>
  <div
    class="level-container d-flex flex-column justify-content-between align-items-center"
  >
    <p class="level-title">
      Sofortpreis <br />
      LEVEL 7
    </p>
    <div class="level-base-container">
      <div class="level-base"></div>
      <p class="level">2</p>
    </div>
    <p class="level-winzone">Level bis Gewinnzone</p>
  </div>
</template>

<script>
import { Vue } from "vue-class-component";

export default class Level extends Vue {}
</script>

<style lang="scss" scoped>
.level-container {
  height: 100%;
  padding: 0.5rem 0 0 0;

  .level-title,
  .level-winzone {
    height: 15%;
    font-size: 0.8rem;
    margin: 0;
  }

  .level-winzone {
    @media screen and (max-width: $breakpoint-lg) {
      font-size: 0.6rem;
    }
  }

  .level-title {
    font-weight: bold;
  }

  .level-base-container {
    height: 100%;
    width: 100%;
    display: flex;
    align-items: center;
    flex-direction: column;
    max-width: 7rem;
    position: relative;
  }

  .level {
    z-index: 1;
    font-size: 3rem;
    position: absolute;
    bottom: 0;
    color: white;
    font-weight: bold;
  }

  .level-base {
    width: 52%;
    height: 61%;
    background: #d2dae2;
    transform: perspective(11px) rotateX(8deg);

    &:after {
      content: "";
      display: block;
      height: 1rem;
      background-color: gray;
      position: absolute;
      bottom: 0;
      width: 100%;
      height: 50%;
    }
  }
}
</style>
