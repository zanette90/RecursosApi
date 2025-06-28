import { useState } from 'react';
import { authAPI } from '../api';
import { useNavigate } from 'react-router-dom';
import '../styles/styles.css';

const Cadastro = () => {
    const [formData, setFormData] = useState({
        username: '',
        email: '',
        password: '',
        confirmPassword: ''
    });
    const [isLoading, setIsLoading] = useState(false);
    const navigate = useNavigate();

    const handleInputChange = (e) => {
        const { id, value } = e.target;
        setFormData(prev => ({
            ...prev,
            [id.replace('register-', '')]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        if (formData.password !== formData.confirmPassword) {
            alert('As senhas não coincidem!');
            return;
        }

        setIsLoading(true);

        try {
            const userData = {
                login: formData.username.trim(),
                email: formData.email.trim(),
                senha: formData.password
            };

            await authAPI.register(userData);
            alert('Cadastro realizado com sucesso!');
            navigate('/login');
        } catch (error) {
            alert(error.message);
        } finally {
            setIsLoading(false);
        }
    };

    return (
        <div className="container">
            <div className="auth-forms">
                <div className="form-container">
                    <h2>Cadastro</h2>
                    <form id="registerForm" onSubmit={handleSubmit}>
                        <div className="form-group">
                            <label htmlFor="register-username">Usuário</label>
                            <input 
                                type="text" 
                                id="register-username" 
                                required
                                value={formData.username}
                                onChange={handleInputChange}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="register-email">Email</label>
                            <input 
                                type="email" 
                                id="register-email" 
                                required
                                value={formData.email}
                                onChange={handleInputChange}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="register-password">Senha</label>
                            <input 
                                type="password" 
                                id="register-password" 
                                required
                                value={formData.password}
                                onChange={handleInputChange}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="register-confirmPassword">Confirmar Senha</label>
                            <input 
                                type="password" 
                                id="register-confirmPassword" 
                                required
                                value={formData.confirmPassword}
                                onChange={handleInputChange}
                            />
                        </div>
                        <button type="submit" disabled={isLoading}>
                            {isLoading ? 'Carregando...' : 'Cadastrar'}
                        </button>
                    </form>
                    <p>Já tem uma conta? <a href="/login" id="go-to-login">Faça login</a></p>
                </div>
            </div>
        </div>
    );
};

export default Cadastro;