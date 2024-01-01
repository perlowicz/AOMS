import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from "./layout/Navbar";
import Home from "./pages/Home";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import AddInvoice from "./invoices/AddInvoice";

function App() {
  return (
    <div className="App">
      <Router>
          <Navbar/>

          <Routes>
              <Route exact path="/" element={<Home/>} />
              <Route exact path="/addInvoice" element={<AddInvoice/>}/>
          </Routes>

      </Router>
    </div>
  );
}

export default App;
