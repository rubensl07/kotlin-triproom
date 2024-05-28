package br.senai.sp.jandira.triproom.repository

import android.content.Context
import br.senai.sp.jandira.triproom.DAO.UsuarioDB
import br.senai.sp.jandira.triproom.model.Usuario

class UsuarioRepository(context: Context) {

    private val db = UsuarioDB.getBancoDeDados(context).usuarioDAO()

    fun salvar(usuario: Usuario):Long{
        return db.salvar(usuario)
    }

    fun buscarTodosOsUsuarios(): List<Usuario>{
        return db.listarTodosOsUsuarios()
    }

    fun buscarUsuarioPeloEmailSenha(email:String, senha:String): Pair<Boolean, Usuario?>{
        val usuario = db.buscarUsuarioPeloEmailSenha(email,senha)
        return Pair(usuario != null, usuario)
    }

    fun buscarUsuarioPeloId(id: Long): Usuario{
        return db.buscarUsuarioPeloId(id)
    }
}