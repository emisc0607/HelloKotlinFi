# HelloKotlinFi-
## Código y notas de la sesión de introducción al desarrollo Android con Kotlin
---
### viewBinding 
Permite enlazar las vistas con la lógica de de la app


- En **build.gradle (Módulo app)** dentro de **android** {...} -> 

        buildFeatures{
            viewBinding true
        }


- En **mainActivity.kt** dentro de **class MainActivity()** {...} ->


        private lateinit var binding: ActivityMainBinding

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)
                ...
            }

### Agregar permisos 
- Dentro de **AndroidManifest.xml** en 
    
        <manifest...>
            <uses-permission android:name="android.permission.INTERNET"/>
            ...
        </manifest>
    

### Agregar una imagen
- Colocar la imagen dentro de la carpeta

        res -> drawable

### ConstrainLayout
Permite definir la ubicacion de los elementos a traves de los atributos:
    
    - ToptoTopOf
    - BottomToBottomOf
    - EndToEndOf
    - StartToStartOf
    - BottomToTopOf
    - TopToBottomOf
    - StartToEndOf
    - EndToStartOf

### Documentación importante
- [Android Developers](https://developer.android.com/docs?hl=es-419)
- [Material Design](https://m2.material.io/)