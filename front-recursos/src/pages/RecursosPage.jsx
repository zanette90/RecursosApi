import React, { useState, useEffect } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlus, faEdit, faTrash, faSave, faTimes } from '@fortawesome/free-solid-svg-icons';
import '../styles/RecursosCRUD.css'; 

const RecursosPage = () => {
  const [recursos, setRecursos] = useState([]);
  const [formData, setFormData] = useState({
    TipoRecurso: '',
    Descricao: '',
    Ativo: true
  });
  const [editingId, setEditingId] = useState(null);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const mockData = [
          { id: 1, TipoRecurso: 'Projetor', Descricao: 'Projetor Full HD', Ativo: true },
          { id: 2, TipoRecurso: 'Notebook', Descricao: 'Notebook i7 16GB', Ativo: true },
          { id: 3, TipoRecurso: 'Sala', Descricao: 'Sala de reuniões 10 pessoas', Ativo: false }
        ];
        setRecursos(mockData);
        setIsLoading(false);
      } catch (error) {
        console.error('Erro ao carregar recursos:', error);
        setIsLoading(false);
      }
    };

    fetchData();
  }, []);

  const handleInputChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === 'checkbox' ? checked : value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    if (editingId) {
      setRecursos(recursos.map(item => 
        item.id === editingId ? { ...formData, id: editingId } : item
      ));
    } else {
      const newRecurso = {
        ...formData,
        id: recursos.length > 0 ? Math.max(...recursos.map(r => r.id)) + 1 : 1
      };
      setRecursos([...recursos, newRecurso]);
    }
    
    resetForm();
  };

  const handleEdit = (recurso) => {
    setFormData({
      TipoRecurso: recurso.TipoRecurso,
      Descricao: recurso.Descricao,
      Ativo: recurso.Ativo
    });
    setEditingId(recurso.id);
  };

  const handleDelete = (id) => {
    if (window.confirm('Tem certeza que deseja excluir este recurso?')) {
      setRecursos(recursos.filter(item => item.id !== id));
    }
  };

  const resetForm = () => {
    setFormData({
      TipoRecurso: '',
      Descricao: '',
      Ativo: true
    });
    setEditingId(null);
  };

  return (
    <div className="recursos-container">
      
      <div className="recursos-form">
        <h3>{editingId ? 'Editar Recurso' : 'Adicionar Novo Recurso'}</h3>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Tipo de Recurso:</label>
            <input
              type="text"
              name="TipoRecurso"
              value={formData.TipoRecurso}
              onChange={handleInputChange}
              required
            />
          </div>
          
          <div className="form-group">
            <label>Descrição:</label>
            <textarea
              name="Descricao"
              value={formData.Descricao}
              onChange={handleInputChange}
              required
            />
          </div>
          
          <div className="form-group checkbox-group">
            <label>Ativo
              <input
                type="checkbox"
                name="Ativo"
                checked={formData.Ativo}
                onChange={handleInputChange}
              />
            </label>
              
          </div>
          
          <div className="form-actions">
            <button type="submit" className="btn-primary">
              <FontAwesomeIcon icon={editingId ? faSave : faPlus} />
              {editingId ? ' Salvar' : ' Adicionar'}
            </button>
            
            {editingId && (
              <button type="button" className="btn-secondary" onClick={resetForm}>
                <FontAwesomeIcon icon={faTimes} /> Cancelar
              </button>
            )}
          </div>
        </form>
      </div>
      
      <div className="recursos-list">
        <h3>Lista de Recursos</h3>
        
        {isLoading ? (
          <p>Carregando recursos...</p>
        ) : recursos.length === 0 ? (
          <p>Nenhum recurso cadastrado.</p>
        ) : (
          <table>
            <thead>
              <tr>
                <th>Tipo de Recurso</th>
                <th>Descrição</th>
                <th>Status</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              {recursos.map((recurso) => (
                <tr key={recurso.id}>
                  <td>{recurso.TipoRecurso}</td>
                  <td>{recurso.Descricao}</td>
                  <td>
                    <span className={`status-badge ${recurso.Ativo ? 'active' : 'inactive'}`}>
                      {recurso.Ativo ? 'Ativo' : 'Inativo'}
                    </span>
                  </td>
                  <td className="actions">
                    <button 
                      onClick={() => handleEdit(recurso)}
                      className="btn-edit"
                    >
                      <FontAwesomeIcon icon={faEdit} />
                    </button>
                    <button 
                      onClick={() => handleDelete(recurso.id)}
                      className="btn-delete"
                    >
                      <FontAwesomeIcon icon={faTrash} />
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
};

export default RecursosPage;