import axios from '../index';

const ListProduct = () => axios.get('/products');

export { ListProduct };
