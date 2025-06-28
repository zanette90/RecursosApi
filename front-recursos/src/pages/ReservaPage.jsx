import React, { useState } from 'react';

const ReservaPage = () => {

    const [formData,setFormData] = useState({
        nome : '',
        cracha : '',
        telefone : '',
        ativo : true
    });

    const handleInputChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFormData(prev => ({
            ...prev,
            [name]: type === 'checkbox' ? checked : value
        }));
    };

    return (
        <div className="responsaveis-group">
            <form >
                <h3>Adicionar Nova Reserva</h3>
                <div className="form-group">
                    <label htmlFor="responsavel-nome">Nome:</label>
                    <input type="text"
                        name="nome"
                        value={formData.nome}
                        onChange={handleInputChange}
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="responsavel-cracha">Cracha:</label>
                    <input type="text"
                        name="cracha"
                        value={formData.cracha}
                        onChange={handleInputChange}
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="responsavel-telefone">Telefone:</label>
                    <input type="text"
                        name="telefone"
                        value={formData.telefone}
                        onChange={handleInputChange}
                        required
                    />
                </div>

                <div className="form-group checkbox-group">
                    <label>
                    <input
                        type="checkbox"
                        name="Ativo"
                        checked={formData.ativo}
                        onChange={handleInputChange}
                    />
                    Ativo
                    </label>
                </div>
                <button type="submit" className="btn-primary">Salvar Responsavel</button>
            </form>
            
        </div>

    );
};
export default ReservaPage;