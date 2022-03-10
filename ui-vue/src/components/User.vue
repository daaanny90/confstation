<template>
  <div class="user-avatar-container d-flex flex-column">
    <div class="user-avatar d-flex flex-column justify-content-around">
      <div
        class="avatar-image"
        :style="'background-image: url(' + require('@/assets/avatar.png') + ')'"
      ></div>
      <p class="user-name">Sonny Melon</p>
    </div>
  </div>
</template>

<script>
import { Vue } from "vue-class-component";

export default class User extends Vue {}
</script>

<style lang="scss" scoped>
.user-avatar {
  height: 100%;

  .avatar-image {
    background-position: center;
    background-size: contain;
    background-repeat: no-repeat;
    border: 4px solid $border-grey;
    border-radius: 50%;
    height: 67%;
    max-width: 7rem;
    width: 100%;
    margin: 0 auto;

    @media screen and (max-width: $breakpoint-md) {
      height: 6rem;
    }

    @media screen and (max-width: $breakpoint-lg) {
      height: 57%;
    }
  }

  .user-name {
    font-weight: bold;
    margin: 0;
    text-align: center;
  }
}
</style>
