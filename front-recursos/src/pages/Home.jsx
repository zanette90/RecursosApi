import { useEffect, useState } from 'react';
import { useNavigate, Outlet, useLocation } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBoxes, faTasks, faCalendarCheck, faUsers } from '@fortawesome/free-solid-svg-icons'; 
import { Layout } from '../components/Layout';
import '../styles/Home.css';

const Home = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [activeSection, setActiveSection] = useState('dashboard');

  useEffect(() => {
    const path = location.pathname;
    if (path.endsWith('/home') || path === '/home') {
      setActiveSection('dashboard');
    } else {
      const section = path.split('/').pop();
      setActiveSection(section);
    }
  }, [location.pathname]);

  useEffect(() => {
    const isLoggedIn = sessionStorage.getItem('isLoggedIn');
    if (!isLoggedIn) {
      navigate('/login');
    }
  }, [navigate]);

  const handleLogout = () => {
    sessionStorage.removeItem('isLoggedIn');
    navigate('/login');
  };

  const handleSectionChange = (section) => {
    if (section === 'recursos') {
        navigate('recursos');
    } else if (section === 'funcoes') {
        navigate('funcoes');
    } else if (section === 'reservas') {
        navigate('reservas');
    } else if (section === 'responsaveis') {
        navigate('responsavel');
    } else {
        section = 'dashboard';
    }
  };

  const isDashboard = activeSection === 'dashboard';

  const renderDashboard = () => (
    <>
      <div className="dashboard-cards">
        <div className="card" onClick={() => handleSectionChange('recursos')}>
          <div className="card-icon">
            <FontAwesomeIcon icon={faBoxes} />
          </div>
          <h3>Recursos</h3>
          <p>Gerencie os recursos disponíveis</p>
        </div>
        <div className="card" onClick={() => handleSectionChange('funcoes')}>
          <div className="card-icon">
            <FontAwesomeIcon icon={faTasks} />
          </div>
          <h3>Funções</h3>
          <p>Configure as funções do sistema</p>
        </div>
        <div className="card" onClick={() => handleSectionChange('reservas')}>
          <div className="card-icon">
            <FontAwesomeIcon icon={faCalendarCheck} />
          </div>
          <h3>Reservas</h3>
          <p>Controle de reservas de recursos</p>
        </div>
        <div className="card" onClick={() => handleSectionChange('responsaveis')}>
          <div className="card-icon">
            <FontAwesomeIcon icon={faUsers} />
          </div>
          <h3>Responsáveis</h3>
          <p>Gerencie os responsáveis</p>
        </div>
      </div>

      <div className="recent-activity">
        <h3>Atividade Recente</h3>
        <p>Nenhuma atividade recente</p>
      </div>
    </>
  );

  return (
    <Layout 
      activeSection={activeSection}
      onSectionChange={handleSectionChange}
      onLogout={handleLogout}
    >
      {isDashboard ? renderDashboard() : <Outlet />}
    </Layout>
  );
};

export default Home;