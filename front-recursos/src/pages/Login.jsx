import { useState } from 'react';
import { authAPI } from '../api';
import '../styles/styles.css';

const Login = () => {
    const [formData, setFormData] = useState({
        username: '',
        password: ''
    });
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState(null);

    const handleInputChange = (e) => {
        const { id, value } = e.target;
        setFormData(prev => ({
            ...prev,
            [id.replace('login-', '')]: value
        }));
        if (error) setError(null);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        if (!formData.username.trim() || !formData.password) {
            setError('Por favor, preencha todos os campos');
            return;
        }

        setIsLoading(true);
        setError(null);

        try {
            const result = await authAPI.login({
                username: formData.username.trim(),
                password: formData.password
            });
            
            if (result.success) {
                sessionStorage.setItem('isLoggedIn', 'true');
                window.location.replace('/home');
            } else {
                setError('Credenciais inválidas');
            }
        } catch (error) {
            setError(error.message || 'Erro ao realizar login');
        } finally {
            setIsLoading(false);
        }
    };

    return (
        <div className="container">
            <div className="auth-forms">
                <div className="form-container">
                    <h2>Login</h2>
                    <form id="loginForm" onSubmit={handleSubmit}>
                        <div className="form-group">
                            <label htmlFor="login-username">Usuário</label>
                            <input 
                                type="text" 
                                id="login-username" 
                                required
                                value={formData.username}
                                onChange={handleInputChange}
                                disabled={isLoading}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="login-password">Senha</label>
                            <input 
                                type="password" 
                                id="login-password" 
                                required
                                value={formData.password}
                                onChange={handleInputChange}
                                disabled={isLoading}
                            />
                        </div>
                        <button type="submit" disabled={isLoading}>
                            {isLoading ? 'Carregando...' : 'Entrar'}
                        </button>
                    </form>
                    <p>Não tem uma conta? <a href="/cadastro" id="go-to-register">Cadastre-se</a></p>
                    <br />
                    {error && <div className="error-message">Error: {error}</div>}
                </div>
            </div>
        </div>
    );
};

export default Login;