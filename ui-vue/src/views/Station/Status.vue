<template>
  <div class="status-container d-flex">
    <div class="status-sidebar flex-column justify-content-between">
      <User />
      <Level />
      <Points />
    </div>
    <div class="status-sidebar-mobile">
      <Level />
      <User />
      <Points />
    </div>
    <div
      class="status-main d-flex flex-column justify-content-center align-items-center"
    >
      <div
        class="background"
        :style="
          'background-image: url(' +
          require('@/assets/status_background.png') +
          ')'
        "
      ></div>
      <p>
        Gut gemacht, du hast dein <br />
        erstes Level erreicht! Viel <br />
        Spaß im Spiel.
      </p>
      <router-link to="/dashboard">
        <Button text="DASHBOARD" />
      </router-link>
    </div>
    <Registration />
  </div>
</template>

<script>
import { Vue, Options } from "vue-class-component";
import User from "@/components/User";
import Level from "@/components/Level";
import Points from "@/components/Points";
import Button from "@/components/Button";
import Registration from "@/components/Registration";

@Options({
  components: {
    User,
    Level,
    Points,
    Button,
    Registration,
  },
})
export default class Status extends Vue {}
</script>

<style lang="scss" scoped>
.status-container {
  height: 100%;

  @media screen and (max-width: $breakpoint-md) {
    flex-direction: column;
  }
}
.status-sidebar-mobile {
  display: none;

  @media screen and (max-width: $breakpoint-md) {
    display: flex;
    justify-content: space-around;
    border-bottom: 1px solid gray;
    height: 35%;
    align-items: center;

    *:nth-child(2) {
      width: 45%;
    }
  }
}
.status-sidebar {
  width: 30%;
  border-right: 1px solid $grey;
  padding: 0 3rem;
  display: flex;

  @media screen and (max-width: $breakpoint-md) {
    display: none;
  }

  @media screen and (max-width: $breakpoint-xl) {
    padding: 0 1rem;
  }

  *:first-child {
    border-bottom: 2px solid $grey;
  }
  *:last-child {
    border-top: 2px solid $grey;
  }

  * {
    height: 33%;
  }
}

.status-main {
  width: 80%;
  position: relative;

  p {
    padding-top: 30%;
    font-size: 1.25rem;
    color: $grey;
    font-weight: bold;
  }

  .background {
    width: 100%;
    height: 80%;
    background-repeat: no-repeat;
    background-position: center;
    background-size: contain;
    position: absolute;
    top: -50px;
    z-index: -1;
  }
}
</style>
