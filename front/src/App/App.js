import "./App.css";
import AppRoutes from "./AppRoutes";
import { BrowserRouter } from "react-router-dom";
import { AppProvider } from "./AppContext";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <AppProvider>
          <AppRoutes />
        </AppProvider>
      </BrowserRouter>
    </div>
  );
}

export default App;
