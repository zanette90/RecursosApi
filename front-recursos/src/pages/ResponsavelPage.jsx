import { useState } from 'react';
import { responsavelApi } from '../api';
import PhoneInput from 'react-phone-number-input';

const ResponsavelPage = () => {

    const [formData, setFormData] = useState({
        nome: '',
        cracha: '',
        telefone: '',
        Ativo: true
    });


    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData(prev => ({
            ...prev,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const response = await responsavelApi.cadastrar(formData);
    };
   
    return (
        <div className="responsaveis-group">
            <form onSubmit={handleSubmit}>
                <h3>Adicionar Novo Responsável</h3>
                <div className="form-group">
                    <label htmlFor="">Nome:</label>
                    <input type="text"
                        name="nome"
                        value={formData.nome}
                        onChange={handleInputChange}
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="">Cracha:</label>
                    <input type="text"
                        name="cracha"
                        value={formData.cracha}
                        onChange={handleInputChange}
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="">Telefone:</label>
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
                        name="ativo"
                        checked={formData.Ativo}
                    />
                    Ativo
                    </label>
                </div>
                <button type="submit" className="btn-primary">Salvar Responsavel</button>
            </form>
        </div>
    );
};
export default ResponsavelPage;
