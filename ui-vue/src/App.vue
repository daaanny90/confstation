<template>
  <div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </div>

  <div v-if="isLoading">Loading...</div>

  <div v-if="!isLoading && stationExsist">
    <router-view :station="station" />
  </div>
  <div v-else-if="!isLoading && !stationExsist">NO STATION</div>
</template>

<script lang="ts">
import { Vue } from "vue-class-component";
import { StationApi } from "@/api/stationApi";
import Station from "@/interfaces/station";

export default class App extends Vue {
  serviceID = process.env.VUE_APP_DEV_STATION_ID;
  station: Station[] = [];
  stationExsist = false;
  isLoading = false;

  getStation = async (): Promise<void> => {
    this.isLoading = true;
    this.station = await StationApi.getStation(this.serviceID);
    this.isLoading = false;

    if (this.station !== null) {
      this.stationExsist = true;
      return;
    }

    this.stationExsist = false;
  };

  mounted(): void {
    this.getStation();
  }
}
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
