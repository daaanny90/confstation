<template>
  <div class="level-container d-flex flex-column align-items-center">
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

  .level-title,
  .level-winzone {
    margin: 0;
  }

  .level-winzone {
    font-size: 0.8rem;
    height: 15;
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
    max-height: 7rem;
  }

  .level {
    z-index: 1;
    font-size: 3rem;
    position: absolute;
    bottom: 9px;
    color: white;
    font-weight: bold;
    margin: 0;
  }

  .level-base {
    width: 52%;
    height: 67%;
    background: #d2dae2;
    transform: perspective(11px) rotateX(8deg);
    max-height: 5rem;

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
