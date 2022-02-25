<template>
  <div class="home">
    <img alt="Vue logo" :src="station.logo.src" />
    <Welcome :station-name="station.name" />
  </div>
</template>

<script lang="ts">
import { Options, Vue } from "vue-class-component";
import Welcome from "@/components/Welcome.vue";
import Station from "@/interfaces/station";

@Options({
  components: {
    Welcome,
  },
  props: {
    station: Object,
  },
})
export default class Home extends Vue {
  station: Station[] = [];
}
</script>
