const apiUrl = 'http://localhost:5501';

export const authAPI = {
    async register(userData) {
        try {
            const response = await fetch(`${apiUrl}/auth/registrar`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(userData)
            });

            if (!response.ok) {
                const errorData = await response.json();
                throw new Error(errorData.message || 'Erro ao cadastrar');
            }

            return await response.json();
        } catch (error) {
            console.error('Registration error:', error);
            throw new Error(error.message || 'Erro na comunicação com o servidor');
        }
    },

        async login(loginData) {
        const response = await fetch(`${apiUrl}/auth/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                login: loginData.username,
                senha: loginData.password
            })
        });

        if (response.ok) {
            return { success: true };
        } else {
            throw new Error('Usuário ou senha incorretos');
        }
    },

    async _parseResponse(response) {
        try {
            const contentType = response.headers.get('content-type');
            const text = await response.text();
            
            if (!contentType || !contentType.includes('application/json')) {
                return { message: text };
            }
            
            return JSON.parse(text);
        } catch (error) {
            console.error('Error parsing response:', error);
            return { message: 'Erro ao processar resposta do servidor' };
        }
    },

    async logout() {
        try {
            const response = await fetch(`${apiUrl}/auth/logout`, {
                method: 'POST',
                credentials: 'include' 
            });

            if (!response.ok) {
                throw new Error('Falha ao realizar logout');
            }

            return true;
        } catch (error) {
            console.error('Logout error:', error);
            throw new Error('Error: ' + error.message);
        }
    },


};

export const recursosAPI = {
  async cadastrar(dados) {
    try {
        const response = await fetch(`${apiUrl}/Recursos`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(dados)
        });
        return await response.json();
    } catch(error) {
        throw new Error("Error: " + error.message);
    }

  },

  async listar(pagina = 0, tamanho = 20) {
    const response = await fetch(`${apiUrl}/Recursos?page=${pagina}&size=${tamanho}&sort=descricao`);
    return await response.json();
  },

  async excluir(id) {
    const response = await fetch(`${apiUrl}/Recursos/${id}`, {
      method: 'DELETE'
    });
    return response.ok;
  }
};

export const  responsavelApi = {
    
    async cadastrar(dados) {
        try {
            const response = await fetch(`${apiUrl}/Responsavel`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(dados)
            });
            return await response.json();
        } catch(error) {
            throw new Error("Error: " + error.message);
        }
    },

    async listar(pagina = 0, tamanho = 20) {
        const response = await fetch(`${apiUrl}/Responsavel?page=${pagina}&size=${tamanho}&sort=descricao`);
        return await response.json();
    },

    async excluir(id) {
        const response = await fetch(`${apiUrl}/Responsavel/${id}`, {
        method: 'DELETE'
        });
        return response.ok;
    }

};

