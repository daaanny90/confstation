<template>
  <button type="button" class="btn btn-primary btn-lg">{{ text }}</button>
</template>

<script>
import { Vue, Options } from "vue-class-component";

@Options({
  props: {
    text: String,
  },
})
export default class Button extends Vue {}
</script>

<style lang="scss" scoped>
button {
  &.btn {
    &.btn-lg {
      width: 15rem;
      font-weight: bold;
      color: white;
    }
  }

}
</style>
