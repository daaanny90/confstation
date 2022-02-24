import App from './App.svelte';

const app = new App({
	target: document.body,
	props: {}
});

export default app;

dateBetween(if( empty(prop("Harvest")),now(),start(prop("Harvest"))), start(prop("Born")), "weeks")