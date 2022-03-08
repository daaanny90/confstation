<template>
  <nav class="navbar navbar-light">
    <div class="container-fluid justify-content-center">
      <span
        class="navbar-brand mb-0 h1 d-flex justify-content-start position-relative"
      >
        <div class="logo event-logo" :style="'background-image: url(' + eventLogo + ')'" alt="Event Logo" />
        <div class="logo station-logo" :style="'background-image: url(' + stationLogo + ')'" alt="Station Logo" />
      </span>
    </div>
  </nav>
</template>

<script>
import { Vue, Options } from "vue-class-component";

@Options({
  props: {
    stationLogo: {
      default: require("@/assets/station_logo.png"),
      type: String,
    },
    eventLogo: {
      default: require("@/assets/station_logo.png"),
      type: String,
    },
  },
})
export default class Navbar extends Vue {}
</script>

<style lang="scss" scoped>
.navbar {
  background-color: transparent;
  border-bottom: 1px solid $grey;
  padding-top: 2rem;

  .navbar-brand {
    width: 100%;
    min-height: 96px;
  }

  .logo {
    width: 120px;
    height: 86px;
    background-repeat: no-repeat;
    background-position: center;
    background-size: contain;
  }

  .station-logo {
    flex: 0 1 auto;
    position: absolute;
    left: 50%;
    transform: translate(-50%);
  }

  .event-logo {
    flex: 0 1 auto;
    margin-right: auto;

    @media screen and (max-width: $breakpoint-sm) {
      display: none;
    }
  }
}
</style>
