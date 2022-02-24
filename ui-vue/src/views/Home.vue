<template>
  <div class="home">
    <img alt="Vue logo" :src="station.logo.src" />
    <Welcome :station-name="station.name" />
  </div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";
import Welcome from "@/components/Welcome.vue";

@Options({
  components: {
    Welcome,
  },
  props: {
    station: Object,
  },
})
export default class Home extends Vue {
  station!: Record<string, unknown>;
}
</script>
