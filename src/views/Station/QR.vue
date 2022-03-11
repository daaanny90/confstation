<template>
  <div class="row qr-container d-flex">
    <div class="col qr-container__text d-flex flex-column">
      <h1 class="fw-bolder">positive scanner teaser</h1>
      <h3 class="fs-4 fw-bolder">Scan Your Badge.</h3>
      <p>
        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Eaque rem
        consequatur officia quaerat necessitatibus quibusdam ipsum praesentium
        ab dolores vel omnis odit sequi velit distinctio a eligendi corrupti,
        iste mollitia.
      </p>
      <router-link to="mainstage"><Button text="NEXT STEP" /></router-link>
    </div>
    <div class="col qr-container__icon">
      <!-- TODO: remove router-link, here only for mockup porpuses -->
      <router-link to="/mainstage">
        <div
          class="qr-icon"
          :style="
            'background-image: url(' +
            require('@/assets/qr_code_Icon.png') +
            ')'
          "
        ></div>
      </router-link>
    </div>
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
export default class QR extends Vue {}
</script>

<style lang="scss" scoped>
.qr-container {
  height: 100%;

  @media screen and (max-width: $breakpoint-md) {
    flex-direction: column-reverse;
  }

  &__text {
    text-align: left;
    padding: $container-padding;
  }

  &__icon {
    .qr-icon {
      background-position: center;
      background-repeat: no-repeat;
      background-size: contain;
      height: 100%;
    }
  }
}
</style>
