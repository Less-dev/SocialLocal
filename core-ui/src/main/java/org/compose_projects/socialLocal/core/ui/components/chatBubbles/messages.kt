package org.compose_projects.socialLocal.core.ui.components.chatBubbles

object messages {
    val message1: messages_example
        get() = object: messages_example {
            override val message: String = "Hola a todos, soy Less, bienvenidos a esta pequeña organización 'Compose Projects'."
            override val hour: String = "20:53 PM"
            override val left: Boolean = false
        }

    val message2: messages_example
        get() = object: messages_example {
            override val message: String = "Hola Less, soy carlos, gracias."
            override val hour: String = "19:55 PM"
            override val left: Boolean = true
        }

    val message3: messages_example
        get() = object: messages_example {
            override val message: String = "Gracias."
            override val hour: String = "20:00 PM"
            override val left: Boolean = true
        }

    val message4: messages_example
        get() = object: messages_example {
            override val message: String = "Buen día, hoy 14 de abril estaré añadiendo mensajes para visualizar como se vé el componente chat_bubbles"
            override val hour: String = "20:01 PM"
            override val left: Boolean = false
        }
    val message5: messages_example
        get() = object: messages_example {
            override val message: String = "ok"
            override val hour: String = "20:02 PM"
            override val left: Boolean = true
        }

    val message6: messages_example
        get() = object: messages_example {
            override val message: String = "Okey ;)"
            override val hour: String = "20:05 PM"
            override val left: Boolean = true
        }
    val message7: messages_example
        get() = object: messages_example {
            override val message: String = "Disculpen, hoy no podré adelantar ninguna issue"
            override val hour: String = "20:06 PM"
            override val left: Boolean = true
        }
    val message8: messages_example
        get() = object: messages_example {
            override val message: String = "No te preocupes :)"
            override val hour: String = "20:07 PM"
            override val left: Boolean = false
        }
    val message9: messages_example
        get() = object: messages_example {
            override val message: String = "Bienvenidos a los nuevos integrantes, lean el README del repositorio principal"
            override val hour: String = "20:08 PM"
            override val left: Boolean = false
        }
    val message10: messages_example
        get() = object: messages_example {
            override val message: String = "https://github.com/compose-projects/socialLocal.git"
            override val hour: String = "20:09 PM"
            override val left: Boolean = false
        }
    val message11: messages_example
        get() = object: messages_example {
            override val message: String = "Vale!"
            override val hour: String = "20:10 PM"
            override val left: Boolean = true
        }

    val message12: messages_example
        get() = object: messages_example {
            override val message: String = "Está bien :D"
            override val hour: String = "20:12 PM"
            override val left: Boolean = true
        }


}