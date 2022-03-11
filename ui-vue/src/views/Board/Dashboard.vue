<template>
  <div class="dashboard-container d-flex">
    <div class="dashboard-sidebar d-flex flex-column">
      <div class="dashboard-sidebar-user p-3">
        <h2>Dashboard</h2>
        <User :show-username="false" />
        <input class="user-name" type="text" placeholder="Sonny Melon" />
      </div>
      <div
        class="dashboard-sidebar-statistics d-flex justify-content-between align-items-center py-2"
      >
        <div
          class="dashboard-points d-flex flex-column justify-content-around px-2"
        >
          <Points />
          <button class="btn btn-primary btn-sm">LEADERBOARD</button>
        </div>
        <div
          class="dashboard-level d-flex flex-column justify-content-around px-2"
        >
          <Level />
          <button class="btn btn-primary btn-sm">LEADERBOARD</button>
        </div>
      </div>
    </div>
    <div class="dashboard-stations d-flex flex-column">
      <div class="not-played-stations stations d-flex justify-content-between flex-wrap">
        <h2>Ungespielte Stationen (8)</h2>
        <div v-for="station in playedStations" :key="station">
          <Station :played="false"/>
        </div>
      </div>
      <div class="played-stations stations d-flex justify-content-between flex-wrap">
        <h2>Gespielte Stationen (7)</h2>
        <div v-for="station in playedStations" :key="station">
          <Station :played="true"/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Vue, Options } from "vue-class-component";
import User from "@/components/User";
import Points from "@/components/Points";
import Level from "@/components/Level";
import Button from "@/components/Button";
import Station from "@/components/Station";

@Options({
  components: {
    User,
    Points,
    Level,
    Button,
    Station,
  },
})
export default class Dashboard extends Vue {
  playedStations = 8;
}
</script>

<style lang="scss" scoped>
.dashboard-container {
  height: 100%;

  .btn {
    color: #fff;
    font-weight: bold;

    @media screen and (max-width: $breakpoint-xl) {
      font-size: .7rem;
    }
  }

  .dashboard-sidebar {
    width: 25%;
    border-radius: 20px;
    border: 1px solid $grey;

    .dashboard-sidebar-user,
    .dashboard-sidebar-statistics {
      height: 50%;
    }

    .dashboard-sidebar-user {
      background: $background-grey;
      border-radius: 20px 20px 0 0;

      h2 {
        font-size: 1.5rem;
      }

      *:nth-child(2) {
        height: 10rem;
      }

      .user-name {
        border-radius: 25px;
        border: none;
        text-align: center;
        padding: 0.3rem 0;
        width: 100%;
        font-weight: bold;

        &::placeholder {
          color: #000;
          font-weight: bold;
          opacity: 1;
        }
      }
    }

    .dashboard-sidebar-statistics {
      .dashboard-points {
        border-right: 1px solid $grey;
      }

      .dashboard-points,
      .dashboard-level {
        height: 100%;
        width: 50%;
      }
    }
  }

  .dashboard-stations {
    width: 75%;

    .stations {
      height: 50%;
      text-align: left;
      padding: 0 2rem;

      h2 {
        font-size: 1.5rem;
        width: 100%;
      }
    }
  }
}
</style>
