import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from "./layout/Navbar";
import Home from "./pages/Home";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import AddClient from "./clients/AddClient";

function App() {
  return (
    <div className="App">
      <Router>
          <Navbar/>

          <Routes>
              <Route exact path="/" element={<Home/>} />
              <Route exact path="/addClient" element={<AddClient/>}/>
          </Routes>

      </Router>
    </div>
  );
}

export default App;
