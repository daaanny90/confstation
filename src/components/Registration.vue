<template>
  <div
    class="registration-container d-flex flex-column justify-content-between"
  >
    <h3>Lead App Example</h3>
    <form class="d-flex flex-column justify-content-between">
      <div class="mb-1">
        <label for="exampleInputEmail1" class="form-label">E-Mail</label>
        <input
          type="email"
          class="form-control"
          id="exampleInputEmail1"
          aria-describedby="emailHelp"
        />
      </div>
      <div class="mb-1">
        <label for="exampleInputName1" class="form-label">Name</label>
        <input type="text" class="form-control" id="exampleInputName1" />
      </div>
      <div class="mb-1">
        <label for="exampleInputSurname1" class="form-label">Nachname</label>
        <input type="text" class="form-control" id="exampleInputSurname1" />
      </div>
      <div class="mb-1 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1" />
        <label class="form-check-label privacy-policy" for="exampleCheck1"
          >Lorem ipsum, dolor sit amet consectetur adipisicing elit. Assumenda
          est similique veritatis eos et aliquam velit molestias.</label
        >
      </div>
      <button type="submit" class="btn btn-primary btn-lg">WEITER</button>
      <router-link to="dashboard"
        >Nein danke, weiter zum Dashboard.</router-link
      >
    </form>
  </div>
</template>

<script>
import { Vue } from "vue-class-component";

export default class Registration extends Vue {}
</script>

<style lang="scss" scoped>
.registration-container {
  background-color: $background-grey;
  border-radius: 20px;
  width: 50%;
  padding: 2rem;
  text-align: left;

  h3 {
    font-weight: bold;
  }

  form {
    height: 100%;
  }

  .form-label,
  .privacy-policy {
    color: $text-grey;
    margin: 0;
    font-size: 0.8rem;
  }

  .form-control {
    border: none;
    border-bottom: 1px solid $text-grey;
    border-radius: 0;
    background: transparent;
  }

  button {
    &.btn {
      &.btn-lg {
        color: #fff;
        width: 100%;
        font-weight: bold;
      }
    }
  }

  a {
    margin: 0 auto;
  }
}
</style>
