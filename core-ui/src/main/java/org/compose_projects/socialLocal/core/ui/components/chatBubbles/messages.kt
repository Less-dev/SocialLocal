package org.compose_projects.socialLocal.core.ui.components.chatBubbles

object messages {
    val message1: messages_example
        get() = object: messages_example {
            override val index: Int = 1
            override val message: String = "Hola a todos, soy Less, bienvenidos a esta pequeña organización 'Compose Projects'."
            override val image: String? = null
            override val hour: String = "20:53 PM"
            override val left: Boolean = false
        }

    val message2: messages_example
        get() = object: messages_example {
            override val index: Int = 2
            override val message: String? = null
            override val image: String? = imageURIs.uri1
            override val hour: String = "19:55 PM"
            override val left: Boolean = true
        }

    val message3: messages_example
        get() = object: messages_example {
            override val index: Int = 3
            override val message: String = "Gracias."
            override val image: String? = null
            override val hour: String = "20:00 PM"
            override val left: Boolean = true
        }

    val message4: messages_example
        get() = object: messages_example {
            override val index: Int = 4
            override val message: String = "Buen día, hoy 14 de abril estaré añadiendo mensajes para visualizar como se vé el componente chat_bubbles"
            override val image: String? = null
            override val hour: String = "20:01 PM"
            override val left: Boolean = false
        }
    val message5: messages_example
        get() = object: messages_example {
            override val index: Int = 5
            override val message: String? = null
            override val image: String? = imageURIs.uri2
            override val hour: String = "20:02 PM"
            override val left: Boolean = true
        }

    val message6: messages_example
        get() = object: messages_example {
            override val index: Int = 6
            override val message: String = "Okey ;)"
            override val image: String? = null
            override val hour: String = "20:05 PM"
            override val left: Boolean = true
        }
    val message7: messages_example
        get() = object: messages_example {
            override val index: Int = 7
            override val message: String = "Disculpen, hoy no podré adelantar ninguna issue"
            override val image: String? = null
            override val hour: String = "20:06 PM"
            override val left: Boolean = true
        }
    val message8: messages_example
        get() = object: messages_example {
            override val index: Int = 8
            override val message: String = "No te preocupes :)"
            override val image: String? = null
            override val hour: String = "20:07 PM"
            override val left: Boolean = false
        }
    val message9: messages_example
        get() = object: messages_example {
            override val index: Int = 9
            override val message: String = "Bienvenidos a los nuevos integrantes, lean el README del repositorio principal"
            override val image: String? = null
            override val hour: String = "20:08 PM"
            override val left: Boolean = false
        }
    val message10: messages_example
        get() = object: messages_example {
            override val index: Int = 10
            override val message: String = "https://github.com/compose-projects/socialLocal.git"
            override val image: String? = null
            override val hour: String = "20:09 PM"
            override val left: Boolean = false
        }
    val message11: messages_example
        get() = object: messages_example {
            override val index: Int = 11
            override val message: String? = null
            override val image: String? = imageURIs.uri3
            override val hour: String = "20:10 PM"
            override val left: Boolean = true
        }

    val message12: messages_example
        get() = object: messages_example {
            override val index: Int = 12
            override val message: String = "Está bien :D"
            override val image: String? = null
            override val hour: String = "20:12 PM"
            override val left: Boolean = true
        }

}

object imageURIs {
    const val uri1 = "/media/socialLocal/chat_global/image1.png"
    const val uri2 = "/media/socialLocal/chat_global/image2.png"
    const val uri3 = "/media/socialLocal/chat_global/image3.png"
}