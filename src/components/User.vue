<template>
  <div class="user-avatar-container d-flex flex-column">
    <div class="user-avatar d-flex flex-column justify-content-around">
      <div
        class="avatar-image"
        :style="'background-image: url(' + require('@/assets/avatar.png') + ')'"
      >
        <div class="user-level">Lv. 7</div>
      </div>
      <p v-if="showUsername" class="user-name">Sonny Melon</p>
    </div>
  </div>
</template>

<script>
import { Vue, Options } from "vue-class-component";

@Options({
  props: {
    showUsername: {
      default: true,
      value: Boolean,
    },
  },
})
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
    max-height: 7rem;
    position: relative;

    @media screen and (max-width: $breakpoint-md) {
      height: 6rem;
    }

    @media screen and (max-width: $breakpoint-lg) {
      height: 57%;
    }

    .user-level {
      width: 3rem;
      height: 1.5rem;
      border-radius: 25px;
      background-color: #d6d6d6;
      color: #fff;
      text-align: center;
      bottom: -10px;
      position: absolute;
      left: 50%;
      transform: translate(-50%);
      font-size: 0.8rem;
      border: 1px solid #fff;
      font-weight: bold;
      display: flex;
      align-items: center;
      justify-content: center;
    }
  }

  .user-name {
    font-weight: bold;
    margin: 0;
    text-align: center;
  }
}
</style>
