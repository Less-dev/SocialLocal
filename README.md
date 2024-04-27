# Social Local
### Una aplicación para chatear con amigos 💬 en una misma red.

1. [`CÓMO CONTRIBUIR`](#Contribuciones)  
  1.1 [Bifurque el proyecto](#configuración-del-proyecto)
     
    1.2 [Descargue el proyecto en su máquina local](#descargue-el-proyecto)  
  
    1.3 [Manténgase actualizado con el repositorio principal](#manténgase-actualizado)
  
      1.3.1 [Agregue el repositorio remoto a su espacio de trabajo](#agregue-el-repositorio-remoto)
  
      1.3.2 [Actualice su espacio de trabajo](#actualice-su-espacio-de-trabajo)
  
      1.3.3 [Combine el repositorio remoto con su espacio de trabajo](#combine-el-repositorio-remoto-con-su-espacio-de-trabajo)
  
    1.4 [Contribuya](#contribuya)  
  
      1.4.1 [Busque una issue](#busque-una-issue-o-problema)  
  
      1.4.2 [Agregue los cambios](#agregue-los-cambios)  
  
      1.4.3 [Describa los cambios](#Describa-los-cambios-realizados)

2. [`ESPECIFICACIONES TÉCNICAS`](#especificaciones-técnicas)
      2.1 [Arquitectura](#arquitectura)
      2.1.2 [Gráfico arquitectura Social Local](#Gráfico-Arquitectura-Social-Local)
      2.2 [Tecnologias](#tecnologias)

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

# `Contribuciones`

## Configuración del proyecto
### Haga una bifurcación de el [proyecto ](https://github.com/compose-projects-android/SocialLocal) a su repositorio privado

# Descargue el proyecto
### Teniendo en cuenta que ya se tiene descargada la herramienta [git](https://git-scm.com/), abra su terminal y clone su repositorio: 
```
git clone https://github.com/miUser/SocialLocal.git
```
![image](https://github.com/compose-projects-android/SocialLocal/assets/166412593/19c7b77c-66e8-4a1c-b473-80a8241acd9d)


# Manténgase actualizado
### Antes de cualquier contribución sincronice el repositorio remoto con su espacio de trabajo

## Agregue el repositorio remoto
```
git remote add upstream https://github.com/compose-projects-android/SocialLocal
```
## Actualice su espacio de trabajo
```
git fetch upstream
```
## Combine el repositorio remoto con su espacio de trabajo

```
git merge upstream/<name_your_branch>
```

# Contribuya
### Busque hacer contribuciones claras y concisas, adjuntando videos u imágenes a sus PR.

## Busque una issue o problema
#### En la sección de issues del [repositorio remoto](https://github.com/compose-projects-android/SocialLocal/issues) mire si encuentra algo acorde a su conocimiento intelectual y que se ajuste a sus tiempos, para ser desarrollada con éxito. Si desea crear una solicitud de cambio haga lo mismo.

![image](https://github.com/compose-projects-android/SocialLocal/assets/166412593/9d58d736-84c9-40fb-8b49-494b28507be5)

## Agregue los cambios
#### En su espacio de trabajo haga factibles los cambios realizados
```
git add .
```
## Describa los cambios realizados
#### A la hora de contribuir, es muy importante describir a detalle lo que se hizo, para que los demás desarrolladores tengan una buena idea de lo que usted desarrolló.

```
git commit -m "Cambios que se hicieron"
```

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

# `Especificaciones Técnicas`

- **Red Local:** Utiliza servicios de red para comunicación entre dispositivos en una red local.
- **Seguridad:** Implementa cifrado en mensajes importantes para proteger la privacidad.
- **UI/UX:** Diseño intuitivo con soporte para temas claros y oscuros para una mejor experiencia de usuario.
- **Pruebas:** Incluye pruebas unitarias, de integración y de UI para asegurar la calidad del software.

# Arquitectura
#### Nos esforzamos por mantener una arquitectura Model-View-ViewModel (MVVM)

![image](https://github.com/compose-projects-android/SocialLocal/assets/166412593/af919336-0dc0-4934-ae25-dcd0f056301e)

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

## Gráfico Arquitectura Social Local

![grafico_sl](https://github.com/compose-projects-android/SocialLocal/assets/166412593/d98528aa-6a40-4fec-96b6-8bb94a498642)

<h2 align="center">🛠 Tecnologías</h2>
<p align="center">
  
  <img src="https://img.shields.io/badge/-Dagger_Hilt-4285F4?style=flat-square&logo=android&logoColor=white" width="120" height="30" />
  <a href="https://developer.android.com/topic/libraries/architecture/viewmodel?hl=es-419">
  <img src="https://img.shields.io/badge/-ViewModel-000000?style=flat-square&logo=android&logoColor=white" width="120" height="30" />  
  </a>

  <img src="https://img.shields.io/badge/-Jetpack_Compose-green?style=flat-square&logo=jetpackcompose&logoColor=black" width="160" height="30" />
  <img src="https://img.shields.io/badge/-Room-red?style=flat-square&logo=database&logoColor=white" width="80" height="30" />

</p>


