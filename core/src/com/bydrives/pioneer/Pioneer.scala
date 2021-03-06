package com.bydrives.pioneer

import com.badlogic.gdx.{Application, Game, Gdx}
import com.bydrives.pioneer.assets.modules.ModuleLoader
import com.bydrives.pioneer.core.client.ClientManager
import com.bydrives.pioneer.core.server.ServerManager

class Pioneer extends Game {
  private var clientManager: ClientManager = null
  private var serverManager: ServerManager = null

  override def create(): Unit = {
    Gdx.graphics.setDisplayMode(1280, 720, false)
    Gdx.app.setLogLevel(Application.LOG_DEBUG)

    println("Starting Pioneer...")

    ModuleLoader.loadModules()
    clientManager = new ClientManager
    serverManager = new ServerManager

    setScreen(clientManager)
  }

  override def render(): Unit = {
    //Here was a line of code which made me debug for 2 hours. RIP.
    if (serverManager != null) serverManager.render(Gdx.graphics.getDeltaTime)
    if (clientManager != null) clientManager.render(Gdx.graphics.getDeltaTime)
  }
}
