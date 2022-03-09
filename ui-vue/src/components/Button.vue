<template>
  <button type="button" class="btn btn-primary py-3">{{ text }}</button>
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
.btn {
  width: 15rem;
  border-radius: $border-radius;
  font-weight: bold;
}
</style>
