<template>
  <div
    :class="!played ? 'played' : ''"
    class="station-container d-flex justify-content-center align-items-center"
    :style="'background-image: url(' + require('@/assets/station.png') + ')'"
  >
  <div v-if="played" class="check" :style="'background-image:url(' + require('@/assets/station_check.png') + ')'"></div>
  </div>
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
  position: relative;

  @media screen and (max-width: $breakpoint-xl) {
    width: 9rem;
  }

  &.played {
    opacity: 0.4;
  }

  .check {
    background-position: center;
    background-repeat: no-repeat;
    background-size: contain;
    width: 1.5rem;
    height: 1.5rem;
    position: absolute;
    top: 5px;
    right: 5px;
  }
}
</style>
