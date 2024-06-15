import { Routes, Route } from 'react-router-dom';
import HeaderStore from './Component/Header';
import Home from './Component/Content/Home';
import Product from './Component/Content/Product';
import Account from './Component/Content/Account';
import './App.scss';

function App() {
  return (
    <div className="App">
      <HeaderStore />
      <div className="content">
        <Routes>
          <Route path="/" Component={Home} />
          <Route path="/orderdetail" Component={Product} />
          <Route path="/Category" Component={Account} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
