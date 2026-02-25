Módulo Usuario
1. Crear usuario

Método: POST

Endpoint: /api/v1/usuarios

Descripción: Permite registrar un nuevo usuario en el sistema.

Body ejemplo:
{
"nombre": "Ivan",
"email": "ivan@mail.com",
"password": "123456"
}

Respuestas:

201 Created → Usuario creado correctamente.

400 Bad Request → Datos inválidos.

2. Listar usuarios

Método: GET

Endpoint: /api/v1/usuarios

Descripción: Retorna la lista completa de usuarios.

Respuesta:

200 OK → Lista de usuarios.

3. Obtener usuario por ID

Método: GET

Endpoint: /api/v1/usuarios/{id}

Descripción: Retorna un usuario específico.

Respuestas:

200 OK

404 Not Found

4. Actualizar usuario

Método: PUT

Endpoint: /api/v1/usuarios/{id}

Descripción: Actualiza los datos de un usuario.

Respuestas:

200 OK

404 Not Found

5. Eliminar usuario

Método: DELETE

Endpoint: /api/v1/usuarios/{id}

Descripción: Elimina un usuario del sistema.

Respuestas:

204 No Content

404 Not Found