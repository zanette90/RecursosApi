import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { 
  faHome, faBoxes, faTasks, faCalendarCheck, 
  faUsers, faCog, faSignOutAlt 
} from '@fortawesome/free-solid-svg-icons';
import '../styles/Home.css';

export const Layout = ({ children, activeSection, onSectionChange, onLogout }) => {
  return (
    <div className="home-container">
      <div className="sidebar">
        <div className="sidebar-header">
          <h2>Sistema de Recursos</h2>
        </div>
        <div className="sidebar-menu">
          <h3>Menu Principal</h3>
        <ul>
          <li className={activeSection === 'dashboard' ? 'active' : ''}>
            <button onClick={() => onSectionChange('dashboard')}>
              <FontAwesomeIcon icon={faHome} /> Dashboard
            </button>
          </li>
          <li className={activeSection === 'recursos' ? 'active' : ''}>
            <button onClick={() => onSectionChange('recursos')}>
              <FontAwesomeIcon icon={faBoxes} /> Recursos
            </button>
          </li>
          <li className={activeSection === 'funcoes' ? 'active' : ''}>
            <button onClick={() => onSectionChange('funcoes')}>
              <FontAwesomeIcon icon={faTasks} /> Funções
            </button>
          </li>
          <li className={activeSection === 'reservas' ? 'active' : ''}>
            <button onClick={() => onSectionChange('reservas')}>
              <FontAwesomeIcon icon={faCalendarCheck} /> Reservas
            </button>
          </li>
          <li className={activeSection === 'responsaveis' ? 'active' : ''}>
            <button onClick={() => onSectionChange('responsaveis')}>
              <FontAwesomeIcon icon={faUsers} /> Responsáveis
            </button>
          </li>
        </ul>
          
          <h3>Configurações</h3>
          <ul>
            <li>
              <button>
                <FontAwesomeIcon icon={faCog} /> Configurações
              </button>
            </li>
            <li>
              <button onClick={onLogout}>
                <FontAwesomeIcon icon={faSignOutAlt} /> Sair
              </button>
            </li>
          </ul>
        </div>
      </div>

      <div className="main-content">
        <div className="header">
          <h3>Bem-vindo ao Sistema</h3>
          <div className="user-info">
            <span>Usuário Logado</span>
            <button className="logout-btn" onClick={onLogout}>
              <FontAwesomeIcon icon={faSignOutAlt} /> Sair
            </button>
          </div>
        </div>

        <div className="content">
          {children}
        </div>
      </div>
    </div>
  );
};