import React, { useState } from 'react';
import PhoneInput from 'react-phone-number-input';

const FuncoesPage = () => {
    const [funcao, setFuncao] = useState({
        tipoFuncao: '',
        role: '',
        ativo: true
    });

    const roles = [
        "GERENTE", "TEPT", "ADMINISTRADOR", "COORDENADOR", "PROFESSOR", "INSTRUTOR", "ADMINISTRATIVO"
    ];

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFuncao((prevFuncao) => ({
            ...prevFuncao,
            [name]: type === 'checkbox' ? checked : value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Dados da função:', funcao);
        
    };

    return (
        <div className="funcoes-container">
            <h3>Adicionar Funções</h3>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Descrição da Função:</label>
                    <input
                        type="text"
                        name="tipoFuncao"
                        value={funcao.tipoFuncao}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className="form-group">
                    <label>Função:</label>
                    <select
                        name="role"
                        value={funcao.role}
                        onChange={handleChange}
                        required
                    >
                        <option value="">Selecione...</option>
                        {roles.map((role) => (
                            <option key={role} value={role}>
                                {role}
                            </option>
                        ))}
                    </select>
                </div>

                <div className="form-group checkbox-group">
                    <label>
                        <input
                            type="checkbox"
                            name="ativo"
                            checked={funcao.ativo}
                            onChange={handleChange}
                        />
                        Ativo
                    </label>
                </div>

                <button type="submit">Salvar Função</button>
            </form>
        </div>
    );
};

export default FuncoesPage;