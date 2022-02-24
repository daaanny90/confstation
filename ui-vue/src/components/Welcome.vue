<template>
  <h1>Welcome to the station {{ stationName }}</h1>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";

@Options({
  props: {
    stationName: String,
  },
})
export default class Welcome extends Vue {
  stationName!: string;
}
</script>
