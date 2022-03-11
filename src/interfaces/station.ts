export default interface Station {
  uuid: string;
  name: string;
  event: {
    uuid: string;
    name: string;
    logo: {
      src: string;
      title: string;
    };
  };
  logo: {
    src: string;
    title: string;
  };
  theme: {
    css: string;
  };
}
