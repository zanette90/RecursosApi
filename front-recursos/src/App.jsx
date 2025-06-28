import { Routes, Route, Navigate } from 'react-router-dom';
import Home from "./pages/Home";
import Cadastro from "./pages/Cadastro";
import Login from "./pages/Login";
import RecursosPage from './pages/RecursosPage';
import FuncoesPage from './pages/FuncoesPage';
import ResponsavelPage from './pages/ResponsavelPage';
import ReservaPage from './pages/ReservaPage';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/home" replace />} />
      <Route path="/login" element={<Login />} />
      <Route path="/cadastro" element={<Cadastro/>} />
      <Route path="/home" element={<Home />}>
        <Route index element={null} />
        <Route path="recursos" element={<RecursosPage />} />
        <Route path="reservas" element={<ReservaPage/>}/>
        <Route path="funcoes" element={<FuncoesPage/>} />
        <Route path="responsavel" element={<ResponsavelPage/>} />
      </Route>
    </Routes>
  )
}
export default App;