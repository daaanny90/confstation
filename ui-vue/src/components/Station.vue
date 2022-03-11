<template>
  <div
    :class="!played ? 'played' : ''"
    class="station-container d-flex justify-content-center align-items-center"
    :style="'background-image: url(' + require('@/assets/station.png') + ')'"
  ></div>
</template>

<script>
import { Vue, Options } from "vue-class-component";

@Options({
  props: {
    played: {
      default: true,
      value: Boolean,
    },
  },
})
export default class Station extends Vue {}
</script>

<style lang="scss" scoped>
.station-container {
  border: 1px solid $grey;
  width: 10rem;
  height: 6rem;
  background-position: center;
  background-repeat: no-repeat;

  @media screen and (max-width: $breakpoint-xl) {
    width: 9rem;
  }

  &.played {
    opacity: 0.4;
  }
}
</style>
