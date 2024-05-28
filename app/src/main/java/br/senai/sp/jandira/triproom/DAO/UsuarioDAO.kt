package br.senai.sp.jandira.triproom.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.triproom.model.Usuario

@Dao
interface UsuarioDAO {

    @Insert
    fun salvar(usuario:Usuario): Long
    @Query("SELECT * FROM tbl_usuarios ORDER BY nome ASC")
    fun listarTodosOsUsuarios(): List<Usuario>

    @Query("SELECT * FROM tbl_usuarios WHERE id = :id")
    fun buscarUsuarioPeloId(id:Long): Usuario

    @Query("SELECT * FROM tbl_usuarios WHERE email = :email and senha = :senha")
    fun buscarUsuarioPeloEmailSenha(email: String, senha: String): Usuario?
}