package com.example.to02_pmdm_navia_juanmanuel.segundaApp.adapter

import com.example.to02_pmdm_navia_juanmanuel.R
import com.example.to02_pmdm_navia_juanmanuel.segundaApp.sitiosWebs
class sitiosWebsProvider {
    companion object {
        val sitiosWebsLists = listOf(
            sitiosWebs(
                "DeepMind",
                "https://www.deepmind.com",
"DeepMind es una subsidiaria de Alphabet que se enfoca en investigación avanzada en inteligencia artificial, con herramientas y proyectos para programadores y científicos.",
                "info@deepmind.com",
"data:image/png;base64,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"            ),
            sitiosWebs(
                "TensorFlow",
                "https://www.tensorflow.org",
                    "TensorFlow es una plataforma de machine learning de código abierto que facilita la creación de modelos de IA para desarrolladores en diversos lenguajes de programación.",
                "tensorflow-support@google.com",
"https://seeklogo.com/images/T/tensorflow-logo-AE5100E55E-seeklogo.com.png"            ),
            sitiosWebs(
                "OpenAI",
                "https://www.openai.com",
                "OpenAI es una organización líder en el desarrollo de modelos de lenguaje y herramientas de IA, como GPT-4 y DALL·E, utilizadas para programación asistida y creación de contenido.",
                "support@openai.com",
"https://static.vecteezy.com/system/resources/previews/022/227/364/non_2x/openai-chatgpt-logo-icon-free-png.png"            ),
            sitiosWebs(
                "GitHub Copilot",
                "https://github.com/features/copilot",
                "GitHub Copilot, impulsado por OpenAI, es un asistente de codificación de IA que ayuda a los programadores a escribir código más rápido y con mayor eficiencia.",
                "copilot-support@github.com",
    "https://www.sharepointeurope.com/wp-content/uploads/2023/09/What-is-GitHub-Copilot.jpg"
            ), sitiosWebs(
                "Hugging Face",
                "https://huggingface.co/",
                "Hugging Face ofrece herramientas avanzadas de procesamiento del lenguaje natural y modelos de machine learning, con una biblioteca activa y comunidad para desarrolladores.",
                "api@huggingface.co",
"https://w7.pngwing.com/pngs/86/980/png-transparent-hugging-face-logo-tech-companies.png")
        )
    }
}