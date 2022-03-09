<template>
  <div class="container app-container d-flex flex-column">
    <Header v-if="station.logo" :stationLogo="station.logo.src" />
    <div v-else>Loading...</div>

    <div v-if="isLoading">Loading...</div>

    <div class="container main" v-if="!isLoading && stationExsist">
      <router-view :station="station" />
    </div>
    <div v-else-if="!isLoading && !stationExsist">NO STATION</div>
    <Footer />
  </div>
</template>

<script lang="ts">
import { Vue, Options } from "vue-class-component";
import { StationApi } from "@/api/stationApi";
import Station from "@/interfaces/station";
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";

@Options({
  components: {
    Header,
    Footer,
  },
})
export default class App extends Vue {
  serviceID = process.env.VUE_APP_DEV_STATION_ID;
  station: Station[] = [];
  stationExsist = false;
  isLoading = false;
  stationLogo = "";

  getStation = async (): Promise<void> => {
    this.isLoading = true;
    await StationApi.getStation(this.serviceID).then((response) => {
      this.station = response;
      this.isLoading = false;
    });

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
  height: 100%;
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

.app-container {
  height: 100%;
}

.main {
  padding: 2rem 0;
  height: 100%;
  flex: 1;
}
</style>
